<template>
    <div class="font-RobotoSlab bg-white flex flex-col h-screen">
        <NavBar />
        <RouterView />
        <MobileInfoFooter/>
    </div>
</template>

<script setup>
import {RouterView} from "vue-router";
import NavBar from "@/components/NavBar.vue";
import MobileInfoFooter from "@/components/MobileInfoFooter.vue";
</script>
