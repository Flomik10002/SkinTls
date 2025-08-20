# SkinTLS — Secure Skins Everywhere

**SkinTLS** is a lightweight Fabric mod that forces Minecraft to load all player skins (and Mojang-hosted capes) over **HTTPS** instead of HTTP.

---

## ✨ Features
- Forces all skin requests from `textures.minecraft.net` to use **secure HTTPS**
- Compatible with all skin/cosmetic mods that use the vanilla `PlayerSkinTextureDownloader`.
- **Note:** external mods (like OptiFine or CustomSkinLoader with their own CDNs) are unaffected.


---

## 💡 Why it matters
Some networks, proxies, and future server setups reject plain HTTP requests. Without HTTPS, skins may fail to load or cause connection errors.  
**SkinTLS** ensures your game always uses secure connections for Mojang-hosted textures.

---

## 📥 Installation
1. Install [Fabric Loader](https://fabricmc.net/) and [Fabric API](https://modrinth.com/mod/fabric-api)
2. Drop **SkinTLS** into your `mods` folder
3. Launch Minecraft — done.

---

> ⚡ Lightweight. Universal. Secure. Never lose your skin again.
