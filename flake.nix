{
  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixpkgs-unstable";
    flake-parts.url = "github:hercules-ci/flake-parts";
  };

  outputs = {flake-parts, ...} @ inputs:
    flake-parts.lib.mkFlake {inherit inputs;} {
      systems = ["x86_64-linux"];

      perSystem = {
        pkgs,
        system,
        ...
      }: let
        javaVersion = 21;

        jdk = pkgs."temurin-bin-${toString javaVersion}";
        gradle = pkgs.gradle_9.override {
          javaToolchains = [jdk];
          java = jdk;
        };

      in {
        devShells.default = pkgs.mkShell {
          packages = [gradle jdk];
        };
      };
    };
}
