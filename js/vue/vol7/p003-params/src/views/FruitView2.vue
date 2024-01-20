<template>
    <!-- propsからパラメーターを取得 ...（1）-->
    <div>名前：{{ props.name }}</div>
    <div>価格：{{ props.price }}円</div>
    <div>個数：{{ props.count }}</div>
</template>
<script setup lang="ts">
// パラメーターの名前、型をpropsに定義 ...（2）
const props = defineProps<{ 
    name: string,
    price: number,
    count: number
}>()
</script>
