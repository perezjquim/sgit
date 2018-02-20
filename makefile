main: update repackage

update:
	@echo "@Updating files...@"
	@cp sgit-java/sgit.jar sgit-deb/opt/sgit/sgit.jar
	@cp sgit-bash/sgit sgit-deb/usr/local/bin/sgit
	@echo "@Files updated!@"

repackage:
	@echo "@Repackaging...@"
	@dpkg-deb --build sgit-deb sgit-install > /dev/null
	@echo "@Repackaged!@"
