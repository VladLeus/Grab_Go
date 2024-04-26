<template>
    <Transition name="mobile-schedule-outer">
        <div v-show="scheduleIsActive" class="w-[375px] bg-second_col h-[375px] rounded-[15px] child">
            <div class="flex flex-col gap-6">
                <slot/>
                <i class="fi fi-sr-cross text-back_elem_col w-[30px] h-[30px] my-4 mx-4"
                   @click="$emit('close-schedule')"></i>
                <h1 class="text-4xl text-back_elem_col font-RobotoSlab-500 pl-5"> Work Schedule </h1>
                <ul class="ml-[30px] text-back_elem_col text-2xl font-RobotoSlab-400">
                    <li>
                        Mon-Fri: 9:00-21:00
                    </li>
                    <li>
                        Sat-Sun: 11:00-21:00
                    </li>
                </ul>
                <p class="text-back_elem_col text-md font-RobotoSlab-300 pl-5">We work without breaks and on
                    holidays!</p>
            </div>
        </div>
    </Transition>
</template>

<script setup>

defineEmits(['close-schedule']);
defineProps({
    scheduleIsActive: {
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

.mobile-schedule-outer-enter-active, .mobile-schedule-outer-leave-active {
    transition: opacity 0.3s ease-in;
}

.mobile-schedule-outer-enter-from, .mobile-schedule-outer-leave-to {
    opacity: 0;
}
</style>