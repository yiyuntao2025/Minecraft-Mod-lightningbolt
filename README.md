# Thunderbolt Mod ⚡

[![Minecraft Version](https://img.shields.io/badge/Minecraft-1.19.2-brightgreen)](https://minecraft.net)
[![Forge Version](https://img.shields.io/badge/Forge-43.2.14-orange)](https://files.minecraftforge.net/net/minecraftforge/forge/index_1.19.2.html)
[![License](https://img.shields.io/badge/License-MIT-blue)](LICENSE)

A simple Minecraft Forge mod that allows you to summon lightning bolts by pressing the **B key** at your crosshair position.

## 📖 Description

This mod adds a simple but fun feature: press **B** to strike lightning at whatever you're looking at! Perfect for:
- Adding dramatic effects to your builds
- Quickly clearing out mobs
- Creating lightning-themed maps
- Just having fun with lightning powers

## ✨ Features

- ⚡ **Summon Lightning** - Press B to strike lightning at your crosshair position
- 🎯 **Precision Aiming** - Lightning strikes exactly where you're looking
- 📍 **Ground Detection** - Automatically finds the ground level (no lightning underground!)
- 🏷️ **Gold Block Marker** - Places a gold block at the strike location (optional, helps with debugging)
- 🌍 **Multiplayer Compatible** - Works on servers (with appropriate permissions)

## 📋 Requirements

- Minecraft **1.19.2**
- Forge **43.2.14**
- Java **17** or higher

## 🚀 Installation

1. **Install Forge** - Download and install Forge 43.2.14 for Minecraft 1.19.2
2. **Download the mod** - Get the latest `thunderbolt-1.0.0.jar` from [Releases](https://github.com/yourusername/thunderbolt/releases)
3. **Place in mods folder** - Copy the .jar file to your Minecraft `mods` folder
   - Windows: `%APPDATA%/.minecraft/mods`
   - Mac: `~/Library/Application Support/minecraft/mods`
   - Linux: `~/.minecraft/mods`
4. **Launch Minecraft** - Start the game with the Forge profile

## 🎮 How to Use

1. **Enter a world** (Creative mode recommended for testing)
2. **Look at any block or location**
3. **Press the B key**
4. **Watch the lightning strike!** ⚡

A gold block will appear at the strike location to help you see where the lightning hit.

## ⚙️ Configuration

Currently, the mod uses fixed key bindings:
- **B** - Summon lightning
- The key can be changed in Minecraft's Controls menu under "Thunderbolt Mod"

## 🛠️ For Developers

### Building from Source

Clone the repository:
```bash
git clone https://github.com/yourusername/thunderbolt.git
```

Navigate to project directory:
```bash
cd lightningbolt
```

Build the mod:
```bash
gradlew build
```

The compiled jar will be in `build/libs/`

### Project Structure
```
thunderbolt/
├── src/main/java/com/example/thunderbolt/
│ ├── ThunderboltMod.java # Main mod class
│ └── KeyBindings.java # Key handling and lightning logic
├── src/main/resources/
│ ├── META-INF/
│ │ └── mods.toml # Mod metadata
│ └── assets/thunderbolt/lang/
│ ├── en_us.json # English localization
│ └── zh_cn.json # Chinese localization
└── build.gradle # Gradle build script
```


## 🤝 Contributing

Contributions are welcome! Feel free to:
- Report bugs
- Suggest features
- Submit pull requests

## 📜 License

This mod is licensed under the MIT License. See [LICENSE](LICENSE) for details.

## 🙏 Credits

- Created by [Your Name]
- Built with Minecraft Forge
- Inspired by the desire to control lightning!

## ❓ FAQ

**Q: Why can't I see the lightning?**
A: Make sure you're in an area with open sky. Lightning won't appear underground.

**Q: Does this work on servers?**
A: Yes, but you need permission to use commands on the server.

**Q: Can I change the key binding?**
A: Yes! Go to Options → Controls → Thunderbolt Mod and change it there.

**Q: Will this affect my world?**
A: Lightning can set fires and damage entities, so use with caution!

---

**⚡ Have fun striking lightning! ⚡**
