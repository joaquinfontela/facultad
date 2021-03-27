#include <SDL2/SDL.h>
#include <SDL2/SDL_render.h>
#include <SDL2/SDL_video.h>
#include <stdbool.h>

int main(int argc, char* argv[]) {
  SDL_Init(SDL_INIT_VIDEO);
  SDL_Window* w;
  SDL_Renderer* r;
  SDL_CreateWindowAndRenderer(800, 600, 0, &w, &r);
  SDL_Event e;

  bool running = true;

  while (running) {
    while (SDL_PollEvent(&e)) {
      if (e.type == SDL_QUIT) running = false;
    }
    int wid, hei;
    SDL_GetWindowSize(w, &wid, &hei);
    SDL_SetRenderDrawColor(r, 255, 0, 255, 0);
    for (int i = 0; i < wid; i++) {
      SDL_RenderDrawLine(r, wid / 2 + i / 2, 0 + (i * 3 / 4), i, hei);
    }
    SDL_RenderPresent(r);
  }

  SDL_DestroyRenderer(r);
  SDL_DestroyWindow(w);
  SDL_Quit();

  return 0;
}
