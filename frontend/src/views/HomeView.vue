<template>
    <main class="flex-1">
        <h1 class="separator text-second_col text-xl font-RobotoSlab-500">Menu</h1>
        <Suspense>
            <Menu />
            <template #fallback>
                <p>Loading...</p>
            </template>
        </Suspense>
    </main>
</template>

<script setup>

import Menu from "@/views/Menu.vue";
</script>
