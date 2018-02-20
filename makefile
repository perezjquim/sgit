main: update repackage

update:
	@echo "@Updating files...@"
	@cp sgit-java/sgit.jar sgit/opt/sgit/sgit.jar
	@cp sgit-bash/sgit sgit/usr/local/bin/sgit
	@echo "@Files updated!@"

repackage:
	@echo "@Repackaging...@"
	@dpkg-deb --build sgit sgit-install > /dev/null
	@echo "@Repackaged!@"
