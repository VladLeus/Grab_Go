<template>
    <div>
        <div
                class="font-RobotoSlab w-[375px] h-[75px] bg-back_elem_col rounded-[15px] mx-auto flex flex-row items-center justify-between"
                @click="togglePizza"
        >
            <p class="text-3xl text-second_col font-RobotoSlab-500 ml-2">Pizza</p>
            <i :class="!showPizza ? 'fi fi-sr-angle-right text-3xl text-second_col mr-2 mt-1' : 'fi fi-sr-angle-down text-3xl text-second_col mr-2 mt-1'"></i>
        </div>
        <transition-group name="list" tag="div">
            <ul class="flex flex-col gap-2 mt-1" v-show="showPizza" v-for="product in products" :key="product.id">
                <li v-if="product.category === 'PIZZA'"
                    class="bg-back_elem_col w-[350px] h-[75px] flex flex-row mx-auto items-center justify-between rounded-[15px]">
                    <div class="flex flex-col font-RobotoSlab-400 text-second_col text-2xl ml-4">
                        <p class="font-RobotoSlab-400">{{ product.name }}</p>
                        <div class="flex flex-row">
                            <p class="text-lg text-fourth_col">{{ product.price }} $</p>
                            <i class="fi fi-rr-shopping-cart-add text-lg text-second_col ml-3"></i>
                        </div>
                    </div>
                    <img class="w-[65px] h-[65px] rounded-[15px] mr-4"
                         :src="'./src/assets/img/' + product.name + '.jpg'" alt="image">
                </li>
            </ul>
        </transition-group>
    </div>
</template>


<script setup>

import {ref} from "vue";

const showPizza = ref(false);

const togglePizza = () => {
    showPizza.value = !showPizza.value;
}
const getProducts = async () => {
    return await fetch("http://localhost:8080/products").then(response => response.json())
}
const products = await getProducts();
</script>

<style>
.arrow-enter-active, .arrow-leave-active{
    transition: opacity 0.3s ease;
}

.arrow-enter-from, .arrow-leave-to {
    opacity: 0;
}

.list-enter-active,
.list-leave-active {
    transition: opacity 0.5s ease;
}

.list-enter-from,
.list-leave-to {
    opacity: 0;
}
</style>