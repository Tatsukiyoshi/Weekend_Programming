<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
</script>
<template>
  <h3>Vue Routerのルート指定（パラメーター渡し）</h3>
  <ul>
    <li><RouterLink to="/fruit1/Apple/300/5">route渡し（/fruit1/Apple/300/5）</RouterLink></li>
    <li><RouterLink to="/fruit2/Orange/400/2">props渡し（/fruit2/Orange/400/2）</RouterLink></li>
  </ul>
  <h3>Vue Routerの出力結果</h3>
  <div style="border:1px solid black">
    <RouterView />
  </div>
</template>

