<template>
    <div>

    </div>
</template>

<script setup>
import {useRoute, useRouter} from "vue-router";
import {ref} from "vue";

const route = useRoute();
const router = useRouter();
const orderId = route.params.orderId;
const getSortedProds = async () => {
    return await fetch(`http://localhost:8080/orders/${orderId}/products/sorted`).then(response => response.json());
}

const sortedProds = await getSortedProds();
const cookingTime = ref(0);
const getReadyTime = () => {
    switch (sortedProds.last.category) {
        case 'PIZZA':
            cookingTime.value = 40;
            break;
        case 'DESSERT':
            cookingTime.value = 15;
            break;
        case 'HOT_DRINK':
            cookingTime.value = 10
            break;
        case 'COLD_DRINK':
            cookingTime.value = 12
            break;
    }
}

console.log(sortedProds);

</script>

<style lang="scss" scoped>

</style>