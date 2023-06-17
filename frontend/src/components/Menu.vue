<template class="overflow-y-scroll">
    <div class="lg:hidden">
        <div>
            <div
                    class="font-RobotoSlab w-[375px] h-[75px] bg-back_elem_col rounded-[15px] mx-auto flex flex-row items-center justify-between"
                    @click="togglePizza"
            >
                <p class="text-3xl text-second_col font-RobotoSlab-500 ml-2">Pizza</p>
                <i :class="!showPizza ? 'fi fi-sr-angle-right text-3xl text-second_col mr-2 mt-1' : 'fi fi-sr-angle-down text-3xl text-second_col mr-2 mt-1'"></i>
            </div>
            <transition-group name="list-pc" tag="ul">
                <li :class="product.category === 'DESSERT' || product.category === 'HOT_DRINK' || product.category === 'COLD_DRINK' ? 'hidden' : 'flex flex-col gap-2 mt-1'"
                    v-show="showPizza" v-for="(product, index) in products" :key="product.id">
                    <div v-if="product.category === 'PIZZA'"
                         class="bg-back_elem_col w-[350px] h-[75px] flex flex-row mx-auto items-center justify-between rounded-[15px]">
                        <div class="flex flex-col font-RobotoSlab-400 text-second_col text-2xl ml-4">
                            <p class="font-RobotoSlab-400">{{ product.name }}</p>
                            <div class="flex flex-row">
                                <p class="text-lg text-fourth_col">{{ product.price }} $</p>
                                <i @click="addToCart(product, index)" :id="index"
                                   class="uil uil-shopping-basket text-xl text-second_col ml-3 mb-1"></i>
                            </div>
                        </div>
                        <img class="w-[65px] h-[65px] rounded-[15px] mr-4"
                             :src="'./src/assets/img/' + product.name + '.jpg'" alt="image">
                    </div>
                </li>
            </transition-group>
        </div>
        <div class="mt-2">
            <div
                    class="font-RobotoSlab w-[375px] h-[75px] bg-back_elem_col rounded-[15px] mx-auto flex flex-row items-center justify-between"
                    @click="toggleDesserts"
            >
                <p class="text-3xl text-second_col font-RobotoSlab-500 ml-2">Desserts</p>
                <i :class="!showDesserts ? 'fi fi-sr-angle-right text-3xl text-second_col mr-2 mt-1' : 'fi fi-sr-angle-down text-3xl text-second_col mr-2 mt-1'"></i>
            </div>
            <transition-group name="list-pc" tag="ul">
                <li :class=" product.category === 'PIZZA' || product.category === 'HOT_DRINK' || product.category === 'COLD_DRINK' ? 'hidden' : 'flex flex-col gap-2 mt-1'"
                    v-show="showDesserts" v-for="(product, index) in products" :key="product.id">
                    <div v-if="product.category === 'DESSERT'"
                         class="bg-back_elem_col w-[350px] h-[75px] flex flex-row mx-auto items-center justify-between rounded-[15px]">
                        <div class="flex flex-col font-RobotoSlab-400 text-second_col text-2xl ml-4">
                            <p>{{ product.name }}</p>
                            <div class="flex flex-row">
                                <p class="text-lg text-fourth_col">{{ product.price }} $</p>
                                <i @click="addToCart(product, index)" :id="index"
                                   class="uil uil-shopping-basket text-xl text-second_col ml-3"></i>
                            </div>
                        </div>
                        <img class="w-[65px] h-[65px] rounded-[15px] mr-4"
                             :src="'./src/assets/img/' + product.name + '.jpg'" alt="image">
                    </div>
                </li>
            </transition-group>
        </div>
        <div class="mt-2">
            <div
                    class="font-RobotoSlab w-[375px] h-[75px] bg-back_elem_col rounded-[15px] mx-auto flex flex-row items-center justify-between"
                    @click="toggleHotDrinks"
            >
                <p class="text-3xl text-second_col font-RobotoSlab-500 ml-2">Hot Drinks</p>
                <i :class="!showHotDrinks ? 'fi fi-sr-angle-right text-3xl text-second_col mr-2 mt-1' : 'fi fi-sr-angle-down text-3xl text-second_col mr-2 mt-1'"></i>
            </div>
            <transition-group name="list-pc" tag="ul">
                <li :class=" product.category === 'PIZZA' || product.category === 'DESSERT' || product.category === 'COLD_DRINK' ? 'hidden' : 'flex flex-col gap-2 mt-1'"
                    v-show="showHotDrinks" v-for="(product, index) in products" :key="product.id">
                    <div v-if="product.category === 'HOT_DRINK'"
                         class="bg-back_elem_col w-[350px] h-[75px] flex flex-row mx-auto items-center justify-between rounded-[15px]">
                        <div class="flex flex-col font-RobotoSlab-400 text-second_col text-2xl ml-4">
                            <p class="font-RobotoSlab-400">{{ product.name }}</p>
                            <div class="flex flex-row">
                                <p class="text-lg text-fourth_col">{{ product.price }} $</p>
                                <i @click="addToCart(product, index)" :id="index"
                                   class="uil uil-shopping-basket text-xl text-second_col ml-3"></i>
                            </div>
                        </div>
                        <img class="w-[65px] h-[65px] rounded-[15px] mr-4"
                             :src="'./src/assets/img/' + product.name + '.jpg'" alt="image">
                    </div>
                </li>
            </transition-group>
        </div>
        <div class="mt-2 mb-2">
            <div
                    class="font-RobotoSlab w-[375px] h-[75px] bg-back_elem_col rounded-[15px] mx-auto flex flex-row items-center justify-between"
                    @click="toggleColdDrinks"
            >
                <p class="text-3xl text-second_col font-RobotoSlab-500 ml-2">Cold Drinks</p>
                <i :class="!showColdDrinks ? 'fi fi-sr-angle-right text-3xl text-second_col mr-2 mt-1' : 'fi fi-sr-angle-down text-3xl text-second_col mr-2 mt-1'"></i>
            </div>
            <transition-group name="list-pc" tag="ul">
                <li :class=" product.category === 'PIZZA' || product.category === 'DESSERT' || product.category === 'HOT_DRINK' ? 'hidden' : 'flex flex-col gap-2 mt-1'"
                    v-show="showColdDrinks" v-for="(product, index) in products" :key="product.id">
                    <div v-if="product.category === 'COLD_DRINK'"
                         class="bg-back_elem_col w-[350px] h-[75px] flex flex-row mx-auto items-center justify-between rounded-[15px]">
                        <div class="flex flex-col font-RobotoSlab-400 text-second_col text-2xl ml-4">
                            <p class="font-RobotoSlab-400">{{ product.name }}</p>
                            <div class="flex flex-row">
                                <p class="text-lg text-fourth_col">{{ product.price }} $</p>
                                <i @click="addToCart(product,index)" :id="index"
                                   class="uil uil-shopping-basket text-xl text-second_col ml-3"></i>
                            </div>
                        </div>
                        <img class="w-[65px] h-[65px] rounded-[15px] mr-4"
                             :src="'./src/assets/img/' + product.name + '.jpg'" alt="image">
                    </div>
                </li>
            </transition-group>
        </div>
    </div>
    <div class="hidden lg:block lg:w-full xl:max-w-[1280px] mx-auto mt-6">
        <div class="menu">
            <div class="flex flex-col gap-4 ml-14">
                <h2 class="text-second_col text-2xl font-RobotoSlab-500">Select the dish:</h2>
                <p @click="togglePizzaPC"
                   class="text-third_col text-2xl hover:text-second_col cursor-pointer font-RobotoSlab-400">Pizza</p>
                <p @click="toggleDessertsPC"
                   class="text-third_col text-2xl hover:text-second_col cursor-pointer font-RobotoSlab-400">Desserts</p>
                <p @click="toggleHotDrinksPC"
                   class="text-third_col text-2xl hover:text-second_col cursor-pointer font-RobotoSlab-400">Hot
                    drinks</p>
                <p @click="toggleColdDrinksPC"
                   class="text-third_col text-2xl hover:text-second_col cursor-pointer font-RobotoSlab-400">Cold
                    drinks</p>
            </div>
            <div>
                <transition-group name="list-pc" tag="ul">
                    <li :class="product.category === 'DESSERT' || product.category === 'HOT_DRINK' || product.category === 'COLD_DRINK' ? 'hidden' : 'flex flex-col gap-2 mt-1'"
                        v-show="showPizza" v-for="(product, index) in products" :key="product.id">
                        <div v-if="product.category === 'PIZZA'"
                             class="bg-back_elem_col w-[550px] h-[100px] flex flex-row mx-auto items-center justify-between rounded-[15px]">
                            <div class="flex flex-col font-RobotoSlab-400 text-second_col text-2xl ml-4 gap-3">
                                <p class="font-RobotoSlab-500 text-3xl">{{ product.name }}</p>
                                <div class="flex flex-row">
                                    <p class="text-xl text-fourth_col">{{ product.price }} $</p>
                                    <i @click="addToCart(product, index+50)" :id="index+50"
                                       class="uil uil-shopping-basket text-2xl cursor-pointer text-second_col ml-3 mb-1"></i>
                                </div>
                            </div>
                            <img class="w-[85px] h-[85px] rounded-[15px] mr-4"
                                 :src="'./src/assets/img/' + product.name + '.jpg'" alt="image">
                        </div>
                    </li>
                </transition-group>
                <transition-group name="list-pc" tag="ul">
                    <li :class=" product.category === 'PIZZA' || product.category === 'HOT_DRINK' || product.category === 'COLD_DRINK' ? 'hidden' : 'flex flex-col gap-2 mt-1'"
                        v-show="showDesserts" v-for="(product, index) in products" :key="product.id">
                        <div v-if="product.category === 'DESSERT'"
                             class="bg-back_elem_col w-[550px] h-[100px] flex flex-row mx-auto items-center justify-between rounded-[15px]">
                            <div class="flex flex-col font-RobotoSlab-400 text-second_col text-2xl ml-4 gap-3">
                                <p class="font-RobotoSlab-500 text-3xl">{{ product.name }}</p>
                                <div class="flex flex-row">
                                    <p class="text-xl text-fourth_col">{{ product.price }} $</p>
                                    <i @click="addToCart(product, index+50)" :id="index+50"
                                       class="uil uil-shopping-basket text-2xl cursor-pointer text-second_col ml-3"></i>
                                </div>
                            </div>
                            <img class="w-[85px] h-[85px] rounded-[15px] mr-4"
                                 :src="'./src/assets/img/' + product.name + '.jpg'" alt="image">
                        </div>
                    </li>
                </transition-group>

                <transition-group name="list-pc" tag="ul">
                    <li :class=" product.category === 'PIZZA' || product.category === 'DESSERT' || product.category === 'COLD_DRINK' ? 'hidden' : 'flex flex-col gap-2 mt-1'"
                        v-show="showHotDrinks" v-for="(product, index) in products" :key="product.id">
                        <div v-if="product.category === 'HOT_DRINK'"
                             class="bg-back_elem_col w-[550px] h-[100px] flex flex-row mx-auto items-center justify-between rounded-[15px]">
                            <div class="flex flex-col font-RobotoSlab-400 text-second_col text-2xl ml-4 gap-3">
                                <p class="font-RobotoSlab-500 text-3xl">{{ product.name }}</p>
                                <div class="flex flex-row">
                                    <p class="text-xl text-fourth_col">{{ product.price }} $</p>
                                    <i @click="addToCart(product, index+50)" :id="index+50"
                                       class="uil uil-shopping-basket cursor-pointer text-2xl text-second_col ml-3"></i>
                                </div>
                            </div>
                            <img class="w-[85px] h-[85px] rounded-[15px] mr-4"
                                 :src="'./src/assets/img/' + product.name + '.jpg'" alt="image">
                        </div>
                    </li>
                </transition-group>

                <transition-group name="list-pc" tag="ul">
                    <li :class=" product.category === 'PIZZA' || product.category === 'DESSERT' || product.category === 'HOT_DRINK' ? 'hidden' : 'flex flex-col gap-2 mt-1'"
                        v-show="showColdDrinks" v-for="(product, index) in products" :key="product.id">
                        <div v-if="product.category === 'COLD_DRINK'"
                             class="bg-back_elem_col w-[550px] h-[100px] flex flex-row mx-auto items-center justify-between rounded-[15px]">
                            <div class="flex flex-col font-RobotoSlab-400 text-second_col text-2xl ml-4 gap-3">
                                <p class="font-RobotoSlab-500 text-3xl ">{{ product.name }}</p>
                                <div class="flex flex-row">
                                    <p class="text-xl text-fourth_col">{{ product.price }} $</p>
                                    <i @click="addToCart(product,index+50)" :id="index+50"
                                       class="uil uil-shopping-basket text-2xl cursor-pointer text-second_col ml-3"></i>
                                </div>
                            </div>
                            <img class="w-[85px] h-[85px] rounded-[15px] mr-4"
                                 :src="'./src/assets/img/' + product.name + '.jpg'" alt="image">
                        </div>
                    </li>
                </transition-group>


            </div>
        </div>
    </div>
</template>


<script setup>
import {ref} from "vue";

const showPizza = ref(false);
const showDesserts = ref(false);
const showHotDrinks = ref(false);
const showColdDrinks = ref(false);
const cart = ref([]);

if (localStorage.getItem('cart')) {
    cart.value = JSON.parse(localStorage.getItem('cart'));
}

const togglePizza = () => {
    showPizza.value = !showPizza.value;
}
const toggleDesserts = () => {
    showDesserts.value = !showDesserts.value;
}
const toggleHotDrinks = () => {
    showHotDrinks.value = !showHotDrinks.value;
}
const toggleColdDrinks = () => {
    showColdDrinks.value = !showColdDrinks.value;
}
const togglePizzaPC = () => {
    showPizza.value = !showPizza.value;
    showDesserts.value = false;
    showHotDrinks.value = false;
    showColdDrinks.value = false;
}
const toggleDessertsPC = () => {
    showDesserts.value = !showDesserts.value;
    showPizza.value = false;
    showHotDrinks.value = false;
    showColdDrinks.value = false;

}
const toggleHotDrinksPC = () => {
    showHotDrinks.value = !showHotDrinks.value;
    showPizza.value = false;
    showDesserts.value = false;
    showColdDrinks.value = false;
}
const toggleColdDrinksPC = () => {
    showColdDrinks.value = !showColdDrinks.value;
    showPizza.value = false;
    showHotDrinks.value = false;
    showDesserts.value = false;
}
const getProducts = async () => {
    return await fetch("http://localhost:8080/products").then(response => response.json())
}
const products = await getProducts();

const addToCart = (product, index) => {
    product.amount = 1;
    if (cart.value.find(item => item.id === product.id)) {
        document.getElementById(`${index}`).classList.remove('uil-shopping-basket');
        document.getElementById(`${index}`).classList.add('uil-check')
        return;
    }
    if (document.getElementById(`${index}`).classList.contains('uil-shopping-basket')) {
        document.getElementById(`${index}`).classList.remove('uil-shopping-basket');
        document.getElementById(`${index}`).classList.add('uil-check')
    }
    cart.value.push(product);
    localStorage.setItem('cart', JSON.stringify(cart.value));
}

</script>

<style>
.list-enter-active,
.list-leave-active {
    transition: opacity 0.5s ease;
}

.list-enter-from,
.list-leave-to {
    opacity: 0;
}

.list-pc-enter-active {
    transition: opacity 1s ease-in;
}

.list-pc-leave-active {
    transition: opacity 0.1s ease-out;
}

.list-pc-enter-from,
.list-pc-leave-to {
    opacity: 0;
}

.menu {
    display: grid;
    grid-template-columns: 1fr 2fr;
}
</style>