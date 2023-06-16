<template>
    <div>
        <p class="mx-1.5 sm:mx-0 text-sm sm:text-xl" v-if="cart.length === 0">
            smth
        </p>
        <ul>
            <li
                v-for="(product, index) in cart"
                :key="product.id"
                class="flex flex-col gap-2 mt-1">
                <div class="bg-back_elem_col w-[350px] h-[75px]
                flex flex-row mx-auto items-center justify-between
                rounded-[15px] font-RobotoSlab-400 text-second_col
                gap-2">
                    <p class="ml-2 text-2xl">{{product.name}}</p>
                    <div class="flex flex-row gap-3 items-center justify-around pr-1.5">
                        <i @click="less(index)" class="fi fi-rr-minus text-lg pt-1"></i>
                        <p class="text-xl">{{ product.amount }}</p>
                        <i @click="more(index)" class="fi fi-rr-plus text-lg pt-1"></i>
                    </div>
                    <p class="mr-2 text-xl text-fourth_col">{{product.price}}$</p>
                </div>
            </li>
        </ul>
    </div>
</template>

<script setup>
let cart = [];

if (localStorage.getItem('cart')) {
     cart = JSON.parse(localStorage.getItem('cart'));
}
const getTables = async () => {
    return await fetch("http://localhost:8080/tables").then(response => response.json())
}
const tables = await getTables();

const less = (index) => cart[index].amount--;
const more = (index) => cart[index].amount++;
</script>

<style lang="scss" scoped>

</style>