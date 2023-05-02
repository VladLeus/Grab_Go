<template>
    <header class="bg-third_col container flex flex-row items-center w-full h-[85px] rounded-b-[15px] justify-between">
        <RouterLink :to="{name: 'home'}">
            <img src="/src/assets/Logo.png" alt="Logo" class="w-[100px] h-[55px] ml-3.5">
        </RouterLink>
        <i class="fi fi-rr-menu-burger text-back_elem_col mr-3.5 duration-150 cursor-pointer" @click="toggleMenu"></i>
        <MobileNavigation :mobile-nav-is-active="showMenu" @close-navigation="toggleMenu">
        </MobileNavigation>
    </header>
</template>

<script setup>
import MobileNavigation from "@/components/MobileNavigation.vue";
import {RouterLink} from "vue-router";
import {ref} from "vue";

let isMenuActive = false;

const showMenu = ref(null);
const toggleMenu = () => {
    showMenu.value = !showMenu.value;
}
</script>

<style>

</style>