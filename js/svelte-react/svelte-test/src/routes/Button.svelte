<script>
    export let handleClick;
    export let color;
</script>

<button style="--color: {color}" on:click={handleClick}>
    Click me!
</button>

<style>
    button {
        color: white;
        background-color: var(--color);
    }
</style>
