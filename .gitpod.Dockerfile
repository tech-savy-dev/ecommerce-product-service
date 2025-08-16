FROM gitpod/workspace-full:2025-08-11-16-56-40

# Install Java 21
RUN sdk install java 21-tem && sdk default java 21-tem

# Confirm Java version
RUN java -version
