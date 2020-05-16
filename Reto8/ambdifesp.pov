#include "colors.inc"

plane {
	y, -2
	pigment {checker Pink, White}	
}

sphere {
    <-3,0,0>, 1
    pigment { Red }
    finish {
      ambient 0.1
      diffuse 0.1
      phong 0.5
      phong_size 10
    }
}

sphere {
    <0,0,0>, 1
    pigment { Green }
    finish {
      ambient 0.9
      diffuse 0.9
      phong .9
      phong_size 100
    }
}

sphere {
    <3,0,0>, 1
    pigment { Grey }
    finish {
      ambient 0.5
      diffuse 0.5
      phong .8
      phong_size 60
    }
}


  light_source {
    <10, 10, -10>
    color White
  }

camera {
	location <0, 0, -10>
	look_at <0, 0, 0>	
}