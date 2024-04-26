<template>
    <footer class="sticky bottom-0 z-0">
        <div class="bg-third_col flex flex-row items-center w-screen h-[85px] rounded-t-[15px] justify-around">
            <div>
                <i class="uil uil-clock-five text-[25px] w-[30px] text-back_elem_col hover:text-second_col"
                   @click="toggleSchedule"></i>
                <MobileInfoSchedule :schedule-is-active="showSchedule"
                                    @close-schedule="toggleSchedule"></MobileInfoSchedule>
            </div>
            <div>
                <i class="uil uil-phone text-[25px] w-[30px]  text-back_elem_col hover:text-second_col"
                   @click="togglePhone"></i>
                <MobileInfoPhone :phone-is-active="showPhone" @close-phone="togglePhone"></MobileInfoPhone>
            </div>
            <div><i class="uil uil-map-marker text-[25px] w-[30px] text-back_elem_col hover:text-second_col"
                    @click="toggleLocation"> </i>
                <MobileInfoLocation :location-is-active="showLocation"
                                    @close-location="toggleLocation"></MobileInfoLocation>
            </div>
            <div>
                <i class="uil uil-instagram text-[25px] w-[30px] text-back_elem_col hover:text-second_col"
                   @click="toggleInstagram"></i>
                <MobileInfoInstagram :instagram-is-active="showInstagram"
                                     @close-instagram="toggleInstagram"></MobileInfoInstagram>
            </div>
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
const toggleSchedule = async () => {
    showSchedule.value = !showSchedule.value;
    console.log(showSchedule.value)
    showPhone.value = false;
    showLocation.value = false;
    showInstagram.value = false;
}
const togglePhone = () => {
    showSchedule.value = false;
    showPhone.value = !showPhone.value;
    showLocation.value = false;
    showInstagram.value = false;
}
const toggleLocation = () => {
    showSchedule.value = false;
    showLocation.value = !showLocation.value;
    showPhone.value = false;
    showInstagram.value = false;
}
const toggleInstagram = () => {
    showSchedule.value = false;
    showInstagram.value = !showInstagram.value;
    showPhone.value = false;
    showLocation.value = false;
}
</script>
