<template>
  <!-- route.paramsからパラメーターを取得 -->
  <div>名前：{{ route.params.name }}</div>
  <div>価格：{{ route.params.price }}円</div>
  <div>個数：{{ route.params.count }}</div>
</template>
<script setup lang="ts">
import { useRoute } from 'vue-router'
const route = useRoute() // routeはルートの情報を含む
</script>