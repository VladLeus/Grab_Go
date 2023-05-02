<template>
    <Transition name="mobile-nav-outer">
        <div v-show="mobileNavIsActive" class="absolute w-full bg-third_col h-screen top-0 left-0">
            <div class="flex flex-col">
                <slot/>
                <i class="fi fi-sr-cross text-back_elem_col w-[30px] h-[30px] py-[30px] px-[30px]"
                   @click="$emit('close-navigation')"></i>
                <ul class="ml-[30px] text-back_elem_col text-3xl font-RobotoSlab-500">
                    <RouterLink :to="{name:'home'}">
                        <li class="pt-6 w-[130px] cursor-pointer flex flex-col hover-underline-animation" @click="$emit('close-navigation')">Menu</li>
                    </RouterLink>

                    <RouterLink :to="{name: 'cart'}">
                        <li class="pt-6 w-[130px] cursor-pointer flex flex-col hover-underline-animation" @click="$emit('close-navigation')">Cart</li>
                    </RouterLink>
                </ul>
            </div>
        </div>
    </Transition>
</template>

<script setup>
import {RouterLink} from "vue-router";

defineEmits(['close-navigation']);
defineProps({
    mobileNavIsActive: {
        type: Boolean,
        default: false
    }
})
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

.mobile-nav-outer-enter-active, .mobile-nav-outer-leave-active{
    transition: opacity 0.3s ease-in;
}

.mobile-nav-outer-enter-from, .mobile-nav-outer-leave-to {
    opacity: 0;
}
</style>