<template>
    <div class="h-full">
        <h1 class="separator text-second_col text-xl font-RobotoSlab-500 max-w-[1260px] mx-auto">Order</h1>
        <Suspense>
            <Order/>
            <template #fallback>
                <p>Loading...</p>
            </template>
        </Suspense>
    </div>
</template>

<script setup>
import Order from "@/components/Order.vue";

</script>

<style lang="scss" scoped>

</style>