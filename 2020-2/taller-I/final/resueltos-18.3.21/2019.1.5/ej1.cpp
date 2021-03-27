#include <SDL2/SDL.h>
#include <SDL2/SDL_render.h>
#include <SDL2/SDL_video.h>

int main() {
  SDL_Init(SDL_INIT_VIDEO);
  SDL_Window* w;
  SDL_Renderer* r;
  SDL_CreateWindowAndRenderer(800, 600, 0, &w, &r);
  SDL_Event e;

  bool run = true;
  while (run) {
    while (SDL_PollEvent(&e))
      if (e.type == SDL_QUIT) run = false;
    int wid, hei;
    SDL_GetWindowSize(w, &wid, &hei);
    SDL_SetRenderDrawColor(r, 255, 255, 0, 255);
    SDL_RenderDrawLine(r, wid / 2, 0, 0, hei - 5);
    SDL_RenderDrawLine(r, 0, hei - 5, wid, hei - 5);
    SDL_RenderDrawLine(r, wid, hei - 5, wid / 2, 0);
    SDL_RenderPresent(r);
  }

  SDL_DestroyRenderer(r);
  SDL_DestroyWindow(w);
  SDL_Quit();

  return 0;
}