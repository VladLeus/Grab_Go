<template class="overflow-y-scroll">
    <div>
        <div
            class="font-RobotoSlab w-[375px] h-[75px] bg-back_elem_col rounded-[15px] mx-auto flex flex-row items-center justify-between"
            @click="togglePizza"
        >
            <p class="text-3xl text-second_col font-RobotoSlab-500 ml-2">Pizza</p>
            <i :class="!showPizza ? 'fi fi-sr-angle-right text-3xl text-second_col mr-2 mt-1' : 'fi fi-sr-angle-down text-3xl text-second_col mr-2 mt-1'"></i>
        </div>
        <transition-group name="list" tag="ul">
            <li :class="product.category === 'DESSERT' || product.category === 'HOT_DRINK' || product.category === 'COLD_DRINK' ? 'hidden' : 'flex flex-col gap-2 mt-1'"
                v-show="showPizza" v-for="(product, index) in products" :key="product.id">
                <div v-if="product.category === 'PIZZA'"
                     class="bg-back_elem_col w-[350px] h-[75px] flex flex-row mx-auto items-center justify-between rounded-[15px]">
                    <div class="flex flex-col font-RobotoSlab-400 text-second_col text-2xl ml-4">
                        <p class="font-RobotoSlab-400">{{ product.name }}</p>
                        <div class="flex flex-row">
                            <p class="text-lg text-fourth_col">{{ product.price }} $</p>
                            <i @click="addToCart(product, index)" :id="index" class="uil uil-shopping-basket text-xl text-second_col ml-3 mb-1"></i>
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
        <transition-group name="list" tag="ul">
            <li :class=" product.category === 'PIZZA' || product.category === 'HOT_DRINK' || product.category === 'COLD_DRINK' ? 'hidden' : 'flex flex-col gap-2 mt-1'"
                v-show="showDesserts" v-for="(product, index) in products" :key="product.id">
                <div v-if="product.category === 'DESSERT'"
                     class="bg-back_elem_col w-[350px] h-[75px] flex flex-row mx-auto items-center justify-between rounded-[15px]">
                    <div class="flex flex-col font-RobotoSlab-400 text-second_col text-2xl ml-4">
                        <p>{{ product.name }}</p>
                        <div class="flex flex-row">
                            <p class="text-lg text-fourth_col">{{ product.price }} $</p>
                            <i @click="addToCart(product, index)" :id="index" class="uil uil-shopping-basket text-xl text-second_col ml-3"></i>
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
        <transition-group name="list" tag="ul">
            <li :class=" product.category === 'PIZZA' || product.category === 'DESSERT' || product.category === 'COLD_DRINK' ? 'hidden' : 'flex flex-col gap-2 mt-1'"
                v-show="showHotDrinks" v-for="(product, index) in products" :key="product.id">
                <div v-if="product.category === 'HOT_DRINK'"
                     class="bg-back_elem_col w-[350px] h-[75px] flex flex-row mx-auto items-center justify-between rounded-[15px]">
                    <div class="flex flex-col font-RobotoSlab-400 text-second_col text-2xl ml-4">
                        <p class="font-RobotoSlab-400">{{ product.name }}</p>
                        <div class="flex flex-row">
                            <p class="text-lg text-fourth_col">{{ product.price }} $</p>
                            <i @click="addToCart(product, index)" :id="index" class="uil uil-shopping-basket text-xl text-second_col ml-3"></i>
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
        <transition-group name="list" tag="ul">
            <li :class=" product.category === 'PIZZA' || product.category === 'DESSERT' || product.category === 'HOT_DRINK' ? 'hidden' : 'flex flex-col gap-2 mt-1'"
                v-show="showColdDrinks" v-for="(product, index) in products" :key="product.id">
                <div v-if="product.category === 'COLD_DRINK'"
                     class="bg-back_elem_col w-[350px] h-[75px] flex flex-row mx-auto items-center justify-between rounded-[15px]">
                    <div class="flex flex-col font-RobotoSlab-400 text-second_col text-2xl ml-4">
                        <p class="font-RobotoSlab-400">{{ product.name }}</p>
                        <div class="flex flex-row">
                            <p class="text-lg text-fourth_col">{{ product.price }} $</p>
                            <i @click="addToCart(product,index)" :id="index" class="uil uil-shopping-basket text-xl text-second_col ml-3"></i>
                        </div>
                    </div>
                    <img class="w-[65px] h-[65px] rounded-[15px] mr-4"
                         :src="'./src/assets/img/' + product.name + '.jpg'" alt="image">
                </div>
            </li>
        </transition-group>
    </div>
</template>


<script setup>

import {ref} from "vue";
import {outputFile} from "tailwindcss/src/oxide/cli/build/utils";

const showPizza = ref(false);
const showDesserts = ref(false);
const showHotDrinks = ref(false);
const showColdDrinks = ref(false);
const cart = ref([]);

if (localStorage.getItem('cart')){
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
const getProducts = async () => {
    return await fetch("http://localhost:8080/products").then(response => response.json())
}
const products = await getProducts();

const addToCart = (product, index) => {
    if (!product.hasOwnProperty('amount')) {
        product.amount = 1;
    }
    cart.value.push(product);
    localStorage.setItem('cart', JSON.stringify(cart.value));

    if (document.getElementById(`${index}`).classList.contains('uil-shopping-basket')) {
        document.getElementById(`${index}`).classList.remove('uil-shopping-basket');
        document.getElementById(`${index}`).classList.add('uil-check')
    }
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
</style>