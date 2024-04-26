<template>
    <Transition name="mobile-phone-outer">
        <div v-show="phoneIsActive" class="w-[375px] bg-second_col h-[375px] rounded-[15px] child z-[1]">
            <div class="flex flex-col gap-6">
                <slot/>
                <i class="fi fi-sr-cross text-back_elem_col w-[30px] h-[30px] my-4 mx-4"
                   @click="$emit('close-phone')"></i>
                <h1 class="text-4xl text-back_elem_col font-RobotoSlab-500 pl-5"> Contact Us </h1>
                <ul class="ml-[30px] text-back_elem_col text-2xl font-RobotoSlab-400">
                    <li>+38 (067) 455 71 90</li>
                    <li class="pt-1">+38 (055) 651 89 01</li>
                    <li class="pt-1">+38 (093) 103 54 86</li>
                </ul>
            </div>
        </div>
    </Transition>
</template>

<script setup>
defineEmits(['close-phone']);
defineProps({
    phoneIsActive: {
        type: Boolean,
        default: false
    }
})
</script>

<style>
.child {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -165%);
}

.mobile-phone-outer-enter-active, .mobile-phone-outer-leave-active {
    transition: opacity 0.3s ease-in;
}

.mobile-phone-outer-enter-from, .mobile-phone-outer-leave-to {
    opacity: 0;
}
</style>