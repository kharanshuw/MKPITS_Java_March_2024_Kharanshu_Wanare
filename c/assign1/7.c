#include <stdio.h>

int main() {
  int entrance_score, avg_performance;
  printf("Enter Entrance Exam Score (out of 100): ");
  scanf("%d", &entrance_score);
  printf("Enter Average Academic Performance (percentage): ");
  scanf("%d", &avg_performance);  
  int min_entrance_score = 60;
  int min_avg_performance = 70;  
  if (entrance_score >= min_entrance_score) {
    if (avg_performance >= min_avg_performance) {
      printf("Congratulations! You are eligible for admission.\n");
    } else {
      printf("Your average performance is below the minimum requirement. \n");
    }
  } else {
    printf("Your entrance exam score is below the minimum requirement. \n");
  }
  return 0;
}
