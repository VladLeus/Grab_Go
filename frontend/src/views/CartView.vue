<template>
    <div class="h-full">
        <h1 class="separator text-second_col text-xl font-RobotoSlab-500">Cart</h1>
        <Suspense>
            <Cart/>
            <template #fallback>
                <p>Loading...</p>
            </template>
        </Suspense>
    </div>
</template>

<script setup>
import Cart from "@/views/Cart.vue";

</script>

<style>

</style>