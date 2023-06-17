<template>
    <Transition name="cart">
        <div class="h-full">
            <h1 class="separator text-second_col text-xl font-RobotoSlab-500 mx-auto max-w-[1260px]">Cart</h1>
            <Suspense>
                <Cart/>
                <template #fallback>
                    <p>Loading...</p>
                </template>
            </Suspense>
        </div>
    </Transition>
</template>

<script setup>
import Cart from "@/components/Cart.vue";

</script>

<style>
.cart-enter-active,
.cart-leave-active {
    transition: opacity 0.5s ease;
}

.cart-enter-from,
.cart-leave-to {
    opacity: 0;
}
</style>