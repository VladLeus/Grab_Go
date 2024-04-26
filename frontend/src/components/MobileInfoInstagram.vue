<template>
    <Transition name="mobile-instagram-outer">
        <div v-show="instagramIsActive" class="w-[375px] bg-second_col h-[375px] rounded-[15px] child">
            <div class="flex flex-col gap-1">
                <slot/>
                <i class="fi fi-sr-cross text-back_elem_col w-[30px] h-[30px] my-4 mx-4"
                   @click="$emit('close-instagram')"></i>
                <h1 class="text-4xl text-back_elem_col font-RobotoSlab-500 pl-5"> Follow us </h1>
                <p class="text-back_elem_col text-2xl font-RobotoSlab-300 pl-5">Instagram: @_G&G_</p>
                <img src="/src/assets/img/insta.png" alt="instagram" class="rounded-[15px] w-[150px] h-[150px] mx-auto">
                <p class="text-back_elem_col text-md font-RobotoSlab-300 pl-5">Follow us on Instagram and be the first
                    to know about our new offers!</p>
            </div>
        </div>
    </Transition>
</template>

<script setup>
defineEmits(['close-instagram']);
defineProps({
    instagramIsActive: {
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

.mobile-instagram-outer-enter-active, .mobile-instagram-outer-leave-active {
    transition: opacity 0.3s ease-in;
}

.mobile-instagram-outer-enter-from, .mobile-instagram-outer-leave-to {
    opacity: 0;
}
</style>