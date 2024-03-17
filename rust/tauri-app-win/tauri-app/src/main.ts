import App from './App.svelte';

// With the Tauri API npm package:
import { invoke } from '@tauri-apps/api/core'

const app = new App({
	target: document.body,
	props: {
		name: 'world'
	}
});

export default app;

document.addEventListener("DOMContentLoaded", () => {
    // This will wait for the window to load, but you could
    // run this function on whatever trigger you want
    invoke("close_splashscreen")
})
