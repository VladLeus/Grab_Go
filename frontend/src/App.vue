<template>
    <div class="font-RobotoSlab bg-white flex flex-col h-screen">
        <NavBar/>
        <RouterView/>
        <MobileInfoFooter class="md:hidden"/>
    </div>
</template>

<script setup>
import {RouterView} from "vue-router";
import NavBar from "@/components/NavBar.vue";
import MobileInfoFooter from "@/components/MobileInfoFooter.vue";

localStorage.clear();
</script>

<style>
.separator {
    display: flex;
    align-items: center;
    text-align: center;
}

.separator::before,
.separator::after {
    content: '';
    flex: 1;
    border-bottom: 1px solid #582F0E;
}

.separator:not(:empty)::before {
    margin-right: 1.25em;
}

.separator:not(:empty)::after {
    margin-left: 1.25em;
}
</style>