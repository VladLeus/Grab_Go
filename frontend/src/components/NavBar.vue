<template>
    <header class="sticky top-0 z-10">
        <nav class="bg-third_col container lg:mx-auto flex flex-row items-center w-full h-[85px] rounded-b-[15px] justify-between max-w-[1280px]">
            <RouterLink :to="{name: 'home'}">
                <img src="/src/assets/img/Logo.png" alt="Logo" class="w-[100px] h-[55px] ml-3.5 lg:ml-[55px]">
            </RouterLink>
            <i class="uil uil-bars text-back_elem_col text-2xl mr-3.5 duration-150 cursor-pointer md:hidden"
               @click="toggleMenu"></i>
            <MobileNavigation class="md:hidden" :mobile-nav-is-active="showMenu" @close-navigation="toggleMenu">
            </MobileNavigation>
            <div class="hidden md:flex flex-row items-center justify-around gap-4 text-back_elem_col mr-[55px] w-[300px]">
                <p @click="router.push({
                name: 'home',
                })" class="text-xl hover-underline-animation cursor-pointer">Menu</p>
                <p @click="router.push({
                name: 'cart',
                })" class="text-xl hover-underline-animation cursor-pointer">Cart</p>
                <p @click="router.push({
                name: 'about',
                })" class="text-xl hover-underline-animation cursor-pointer">About Us</p>
            </div>
        </nav>
    </header>
</template>

<script setup>
import MobileNavigation from "@/components/MobileNavigation.vue";
import {RouterLink, useRouter} from "vue-router";
import {ref} from "vue";

const router = useRouter()

const showMenu = ref(null);
const toggleMenu = () => {
    showMenu.value = !showMenu.value;
}
</script>

<style>
.hover-underline-animation {
    position: relative;
}

.hover-underline-animation::after {
    content: '';
    position: absolute;
    width: 100%;
    transform: scaleX(0);
    height: 2px;
    bottom: 0;
    left: 0;
    background-color: #E6CCB2;
    transform-origin: bottom right;
    transition: transform 0.25s ease-out;
}

.hover-underline-animation:hover::after {
    transform: scaleX(1);
    transform-origin: bottom left;
}


</style>