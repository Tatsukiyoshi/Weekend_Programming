<template>
  <h3>Vue Routerのルート指定</h3>
  <ul>
    <li>
      <RouterLink to="/single">
        1つのコンポーネント（/single）
      </RouterLink>
    </li>
    <li>
      <RouterLink to="/single-with-children">
        1つのコンポーネントとn個の子要素（/single-with-children）
      </RouterLink>
    </li>
    <li>
      <RouterLink to="/single-with-children/child1">
        1つのコンポーネントとn個の子要素（/single-with-children/child1）
      </RouterLink>
    </li>
    <li>
      <RouterLink to="/single-with-children/child2">
        1つのコンポーネントとn個の子要素（/single-with-children/child2）
      </RouterLink>
    </li>
    <li>
      <RouterLink to="/multiple">
        n個のコンポーネント（/multiple）
      </RouterLink>
    </li>
    <li>
      <RouterLink to="/multiple-with-children">
        n個のコンポーネントとm個の子要素（/multiple-with-children）
      </RouterLink>
    </li>
    <li>
      <RouterLink to="/multiple-with-children/child1">
        n個のコンポーネントとm個の子要素（/multiple-with-children/child1）
      </RouterLink>
    </li>
    <li>
      <RouterLink to="/multiple-with-children/child2">
        n個のコンポーネントとm個の子要素（/multiple-with-children/child2）
      </RouterLink>
    </li>
    <li>
      <RouterLink to="/">
        別のパスへのリダイレクト（「/」から「/single」へ）
      </RouterLink>
    </li>
  </ul>
  <h3>Vue Routerの出力結果</h3>
  <div style="border:solid 1px black; padding: 10px;">
    <RouterView name="Header" /><!-- ヘッダーのRouterView -->
    <RouterView /><!-- デフォルトのRouterView -->
    <RouterView name="Footer" /><!-- フッターのRouterView -->
  </div>
</template>
