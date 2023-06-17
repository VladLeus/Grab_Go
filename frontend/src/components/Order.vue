<template>
    <div v-if="route.query.isReady" class="flex flex-col gap-4 items-center justify-center my-6">
        <p class="text-second_col text-2xl font-RobotoSlab-500">Your order № {{ orderId }}</p>
        <p class="text-second_col text-sm font-RobotoSlab-400">Your order has been accepted</p>
        <p class="text-second_col text-sm font-RobotoSlab-400"> It will be ready in:</p>
        <p class="text-second_col text-4xl font-RobotoSlab-500">{{ cookingTime }} min</p>
    </div>
    <div v-if="!route.query.isReady" class="flex flex-col gap-4 items-center justify-center my-6">
        <p class="text-second_col text-2xl font-RobotoSlab-500">Your order № {{ orderId }}</p>
        <p class="text-second_col text-sm font-RobotoSlab-400">Your order is ready</p>
        <p class="text-second_col text-sm font-RobotoSlab-400"> Enjoy your pharmacy!</p>
    </div>
</template>

<script setup>
import {useRoute, useRouter} from "vue-router";
import {ref} from "vue";

const route = useRoute();
const router = useRouter();
const orderId = route.params.orderId;
const cookingTime = ref(0);
const getCookingTime = async () => {
    return await fetch(`http://localhost:8080/orders/${orderId}/products/cooking`).then(response => response.json());
}

cookingTime.value = await getCookingTime();

const interval = setInterval(async () => {
    if (cookingTime.value > 0) {
        cookingTime.value--;
    } else {
        let query = Object.assign({}, route.query);
        delete query.isReady;
        router.replace({query});
        if (query.tableId !== null) {
            let requestOptions = {
                method: 'PUT',
                redirect: 'follow'
            };
            clearInterval(interval);
            return await fetch(`http://localhost:8080/tables/${route.query.tableId}`, requestOptions)
        }
        clearInterval(interval);
    }
}, 2500)

</script>

<style lang="scss" scoped>

</style>