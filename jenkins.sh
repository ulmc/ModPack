cd /var/jenkins/mcp/
cp -R $WORKSPACE/src/ru /var/jenkins/mcp/src/
python runtime/recompile.py
python runtime/reobfuscate.py
cd reobf/minecraft
zip -r -D -9 $WORKSPACE/builds/ulmcModPack_$BUILD_NUMBER *
cd ../..
cd src/
zip -r -D -9 $WORKSPACE/builds/ulmcModPack_$BUILD_NUMBER $WORKSPACE/src/mcmod.info
zip -r -D -9 $WORKSPACE/builds/ulmcModPack_$BUILD_NUMBER $WORKSPACE/src/assets
cd ..