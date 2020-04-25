I built mesa 18.2.3 in a docker image based on `ubuntu:bionic`

```
meson --buildtype=release -Degl=false -Dgallium-vdpau=false -Dgallium-xvmc=false -Dgallium-omx=disabled -Dgallium-drivers=swrast,swr -Dplatforms=x11 -Dglx=gallium-xlib -Dopengl=true  -Dvulkan-drivers= -Dtexture-float=true -Dosmesa=gallium -Ddri-drivers= build
ninja -C build
DESTDIR=/root/mesa-swr ninja -C install
```