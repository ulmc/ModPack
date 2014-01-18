rm -r $WORKSPACE/target/
mkdir $WORKSPACE/target/
cd /var/jenkins/mcp/
cp -R $WORKSPACE/src/ru src/minecraft/
python runtime/recompile.py
python runtime/reobfuscate.py
cp -R /var/jenkins/mcp/reobf/minecraft/ru $WORKSPACE/target/
cp -R $WORKSPACE/src/mcmod.info $WORKSPACE/target/
cp -R $WORKSPACE/LICENSE.txt $WORKSPACE/target/
cp -R $WORKSPACE/src/assets $WORKSPACE/target/
cd $WORKSPACE/target/
zip -r -D -9 $WORKSPACE/artifacts/ulmcModPack_$BUILD_NUMBER *
