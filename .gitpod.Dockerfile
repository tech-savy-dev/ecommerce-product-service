FROM gitpod/workspace-full

# Install Java 21
RUN sdk install java 21-tem && sdk default java 21-tem

# Confirm Java version
RUN java -version
