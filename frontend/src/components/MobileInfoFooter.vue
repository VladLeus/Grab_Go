<template>
    <footer class="bg-third_col container flex flex-row items-center w-full h-[85px] rounded-t-[15px] justify-around">
        <div>
            <i class="fi fi-rr-clock-five text-[20px] w-[30px] text-back_elem_col hover:text-second_col"
              @click="toggleSchedule"></i>
            <MobileInfoSchedule :schedule-is-active="showSchedule"
                                @close-schedule="toggleSchedule"></MobileInfoSchedule>
        </div>
        <div>
            <i class="fi fi-rr-phone-call text-[20px] w-[30px]  text-back_elem_col hover:text-second_col"
              @click="togglePhone"></i>
            <MobileInfoPhone :phone-is-active="showPhone" @close-phone="togglePhone"></MobileInfoPhone>
        </div>
        <div><i class="fi fi-rr-marker text-[20px] w-[30px] text-back_elem_col hover:text-second_col"
              @click="toggleLocation"> </i>
            <MobileInfoLocation :location-is-active="showLocation"
                                @close-location="toggleLocation"></MobileInfoLocation>
        </div>
        <div>
            <i class="fi fi-brands-instagram text-[20px] w-[30px] text-back_elem_col hover:text-second_col"
              @click="toggleInstagram"></i>
            <MobileInfoInstagram :instagram-is-active="showInstagram"
                                 @close-instagram="toggleInstagram"></MobileInfoInstagram>
        </div>
    </footer>
</template>

<script setup>
import MobileInfoSchedule from "@/components/MobileInfoSchedule.vue";
import MobileInfoPhone from "@/components/MobileInfoPhone.vue";
import MobileInfoLocation from "@/components/MobileInfoLocation.vue";
import MobileInfoInstagram from "@/components/MobileInfoInstagram.vue";
import {ref} from "vue";

const showSchedule = ref(null);
const showPhone = ref(null);
const showLocation = ref(null);
const showInstagram = ref(null);
const toggleSchedule = () => {
    showSchedule.value = !showSchedule.value;
}
const togglePhone = () => {
    showPhone.value = !showPhone.value;
}
const toggleLocation = () => {
    showLocation.value = !showLocation.value;
}
const toggleInstagram = () => {
    showInstagram.value = !showInstagram.value;
}
</script>
