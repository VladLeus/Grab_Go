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

<style>
.separator {
    display: flex;
    align-items: center;
    text-align: center;
}

.separator::before,
.separator::after {
    content: '';
    flex: 1;
    border-bottom: 1px solid #582F0E;
}

.separator:not(:empty)::before {
    margin-right: 1.25em;
}

.separator:not(:empty)::after {
    margin-left: 1.25em;
}
</style>