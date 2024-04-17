#include <stdio.h>

int main() {
  float angle;

  printf("Enter the angle measure in degrees: ");
  scanf("%f", &angle);

  if (angle < 0) {
    printf("Angle measure cannot be negative.\n");
  } else if (angle == 0) {
    printf("The angle is straight.\n");
  } else if (angle < 90) {
    printf("The angle is acute.\n");
  } else if (angle == 90) {
    printf("The angle is right.\n");
  } else if (angle < 180) {
    printf("The angle is obtuse.\n");
  } else {
    printf("The angle is considered straight or reflex (more than 180 degrees).\n");
  }

  return 0;
}
