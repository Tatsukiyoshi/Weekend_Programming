<template>
  <!-- propsからパラメーターを取得 -->
  <div>名前：{{ props.name }}</div>
  <div>価格：{{ props.price }}円</div>
  <div>個数：{{ props.count }}</div>
</template>
<script setup lang="ts">
const props = defineProps<{ // パラメーターの名前、型をpropsに定義
  name: string,
  price: number,
  count: number
}>()
</script>