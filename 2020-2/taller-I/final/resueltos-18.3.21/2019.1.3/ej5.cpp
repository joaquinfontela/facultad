#include <SDL2/SDL.h>
#include <SDL2/SDL_render.h>
#include <SDL2/SDL_video.h>
#include <stdbool.h

// g++ ej5.cpp -L"lib" -Wall -lSDL2main -lSDL2 -lSDL2_image

#define WIDTH 800
#define HEIGHT 600

int main(int argc, char* argv[]) {
  SDL_Init(SDL_INIT_VIDEO);
  SDL_Window* w;
  SDL_Renderer* r;
  SDL_CreateWindowAndRenderer(WIDTH, HEIGHT, SDL_RENDERER_ACCELERATED, &w, &r);
  SDL_Event e;

  bool run = true;
  while (run) {
    while (SDL_PollEvent(&e)) {
      if (e.type == SDL_QUIT) run = false;
    }
    int wid, hei;
    SDL_GetWindowSize(w, &wid, &hei);
    SDL_SetRenderDrawColor(r, 255, 0, 0, 255);
    SDL_RenderDrawLine(r, 0, 0, wid, hei);
    SDL_RenderDrawLine(r, 0, hei, wid, 0);
    SDL_RenderPresent(r);
  }

  SDL_DestroyRenderer(r);
  SDL_DestroyWindow(w);
  SDL_Quit();

  return 0;
}