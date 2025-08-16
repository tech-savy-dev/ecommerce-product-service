FROM gitpod/workspace-full:2025-08-11-16-56-40

# Install Java 21 using SDKMAN!
RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install java 21-tem && sdk default java 21-tem"

# Confirm Java version
RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && java -version"