<template>
    <div>
        <p class="mx-auto font-RobotoSlab-500 text-second_col text-xl w-[345px]" v-if="cart.length === 0">
            You haven't added any products yet.
        </p>
        <ul>
            <li
                    v-for="(product, index) in cart"
                    :key="product.id"
                    class="flex flex-col gap-2 mt-1">
                <div class="bg-back_elem_col w-[350px] h-[75px]
                flex flex-row mx-auto items-center justify-between
                rounded-[15px] font-RobotoSlab-400 text-second_col
                gap-2 sm:w-[450px] lg:w-[650px]">
                    <p class="ml-2 text-2xl w-[100px] sm:w-[175px]">{{ product.name }}</p>
                    <div class="flex flex-row gap-3 items-center justify-around pr-1.5">
                        <i @click="less(index)" class="fi fi-rr-minus text-lg pt-1"></i>
                        <p class="text-xl">{{ product.amount }}</p>
                        <i @click="more(index)" class="fi fi-rr-plus text-lg pt-1"></i>
                    </div>
                    <p class="mr-2 text-xl text-fourth_col w-[65px]">
                        {{ Number((product.price * product.amount).toFixed(2)) }}$</p>
                </div>
            </li>
        </ul>
        <div v-if="cart.length !== 0"
             class="w-[375px] sm:w-[450px] lg:w-[650px] flex flex-row items-center justify-between mx-auto my-4">
            <p class="text-second_col text-2xl font-RobotoSlab-500">Total amount:</p>
            <p class="text-fourth_col text-xl font-RobotoSlab-500">{{ total }}$</p>
        </div>
        <h1 v-if="cart.length !== 0"
            class="separator text-second_col text-xl mx-auto max-w-[1260px] font-RobotoSlab-500">Restaurant</h1>
        <div v-if="cart.length !== 0" class="flex flex-col gap-4 w-[375px] mx-auto sm:w-[450px] lg:w-[650px]">
            <div class="flex flex-row mx-2 items-center justify-between">
                <p class="text-second_col text-xl font-RobotoSlab-500">Choose order type:</p>
                <select id="order" v-model="order" @change="selectType"
                        class="bg-back_elem_col rounded-[15px] pl-0.5 h-[45px] w-[180px] text-third_col">
                    <option class="rounded-[15px] text-third_col outline-0" v-for="option in orderType" :value="option">
                        {{ option }}
                    </option>
                </select>
            </div>
            <Transition name="table">
                <div v-if="isInside" class="flex flex-row mx-2 items-center justify-between">
                    <p class="text-second_col text-xl font-RobotoSlab-500">Choose table:</p>
                    <select id="table" v-model="selectedTable"
                            class="bg-back_elem_col rounded-[15px] pl-0.5 h-[45px] w-[180px] text-third_col">
                        <option v-show="option.orderId === null" class="rounded-[15px] text-third_col outline-0"
                                v-for="option in tables"
                                :value="option">
                            {{ option.name }}
                        </option>
                    </select>
                </div>
            </Transition>
            <div @click="createOrder"
                 class="flex items-center justify-center w-[350px] h-[45px] mx-auto bg-fourth_col rounded-[15px] cursor-pointer hover:drop-shadow-xl mb-6">
                <p class="text-back_elem_col text-xl font-RobotoSlab-400">Make an order</p>
            </div>
        </div>
    </div>
</template>

<script setup>
import {ref} from 'vue';
import {useRoute, useRouter} from "vue-router";


const cart = ref([]);
const total = ref(0);
const restaurant = ['Blahovisna Str.', 'T. Shevchenko Blvd.', '\"Sosnovy Bir\"']
const orderType = ['Inside', 'Outside'];
let order = orderType[1];
const isInside = ref(false);
const router = useRouter();
const route = useRoute();

if (localStorage.getItem('cart')) {
    cart.value = JSON.parse(localStorage.getItem('cart'));
}
const getTotalPrice = () => {
    let temp = 0;
    cart.value.forEach(item => {
        temp += item.price;
        total.value = Number(temp.toFixed(2));
    })
}
getTotalPrice();
const less = (index) => {
    cart.value[index].amount--;
    total.value = Number((total.value - cart.value[index].price).toFixed(2));
    if (cart.value[index].amount < 1) {
        cart.value.splice(index, 1);
    }
    localStorage.setItem('cart', JSON.stringify(cart.value));
};

const more = (index) => {
    cart.value[index].amount++;
    total.value = Number((total.value + cart.value[index].price).toFixed(2));
    localStorage.setItem('cart', JSON.stringify(cart.value));
};
const getTables = async () => {
    return await fetch("http://localhost:8080/tables").then(response => response.json())
}
const tables = await getTables();
let selectedTable = tables[0];

const selectType = () => {
    isInside.value = order === 'Inside';
}
const addProdsToOrder = async (orderReq) => {
    for (const item of cart.value) {
        let myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        let productsAddBody = JSON.stringify({
            "productId": item.id,
            "quantity": item.amount
        })

        let requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: productsAddBody,
            redirect: 'follow'
        };
        const orderId = orderReq.id;
        const req = await fetch(`http://localhost:8080/orders/${orderId}/products`, requestOptions).then(response => response.json());
        console.log(req);
    }
}
const createOrder = async () => {
    let myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const type = order.toUpperCase();
    let tableId = null;
    if (order === 'Inside') {
        tableId = selectedTable.id;
    }
    let requestBody = JSON.stringify({
        "name": "order",
        "type": type,
        "tableId": tableId
    });
    let requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: requestBody,
        redirect: 'follow'
    };

    const orderReq = await fetch("http://localhost:8080/orders", requestOptions).then(response => response.json());
    console.log(orderReq);
    await addProdsToOrder(orderReq);

    localStorage.clear();
    router.push({
        name: 'order',
        params: {orderId: orderReq.id},
        query: {
            isReady: false,
            tableId: tableId
        }
    })
}


</script>

<style>
.table-enter-active,
.table-leave-active {
    transition: opacity 0.5s ease;
}

.table-enter-from,
.table-leave-to {
    opacity: 0;
}
</style>