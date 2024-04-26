<template>
    <Transition name="mobile-location-outer">
        <div v-show="locationIsActive" class="w-[375px] bg-second_col h-[375px] rounded-[15px] child">
            <div class="flex flex-col gap-6">
                <slot/>
                <i class="fi fi-sr-cross text-back_elem_col w-[30px] h-[30px] my-4 mx-4"
                   @click="$emit('close-location')"></i>
                <h1 class="text-4xl text-back_elem_col font-RobotoSlab-500 pl-5"> Our location </h1>
                <ul class="ml-[30px] text-back_elem_col text-2xl font-RobotoSlab-400">
                    <li>Blahovisna Street 15/2</li>
                    <li class="pt-1">Park "Sosnovy Bir"</li>
                    <li class="pt-1">Taras Shevchenko Blvd. 41</li>
                </ul>
            </div>
        </div>
    </Transition>
</template>

<script setup>
defineEmits(['close-location']);
defineProps({
    locationIsActive: {
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

.mobile-location-outer-enter-active, .mobile-location-outer-leave-active {
    transition: opacity 0.3s ease-in;
}

.mobile-location-outer-enter-from, .mobile-location-outer-leave-to {
    opacity: 0;
}
</style>