#include <SDL2/SDL.h>
#include <SDL2/SDL_render.h>
#include <SDL2/SDL_video.h>

int main(int argc, char* argv[]) {
  SDL_Init(SDL_INIT_VIDEO);
  SDL_Window* w;
  SDL_Renderer* r;
  SDL_CreateWindowAndRenderer(800, 600, 0, &w, &r);
  SDL_Event e;

  bool running = true;
  while (running) {
    while (SDL_PollEvent(&e)) {
      if (e.type == SDL_QUIT) {
        running = false;
      }
    }
    int wid, hei;
    SDL_GetWindowSize(w, &wid, &hei);
    SDL_SetRenderDrawColor(r, 0, 0, 255, 255);
    SDL_RenderDrawLine(r, wid / 2 - 50, hei / 2 - 50, wid / 2 + 50,
                       hei / 2 - 50);
    SDL_RenderDrawLine(r, wid / 2 + 50, hei / 2 - 50, wid / 2 + 50,
                       hei / 2 + 50);
    SDL_RenderDrawLine(r, wid / 2 + 50, hei / 2 + 50, wid / 2 - 50,
                       hei / 2 + 50);
    SDL_RenderDrawLine(r, wid / 2 - 50, hei / 2 + 50, wid / 2 - 50,
                       hei / 2 - 50);
    SDL_RenderPresent(r);
  }

  SDL_DestroyRenderer(r);
  SDL_DestroyWindow(w);
  SDL_Quit();

  return 0;
}
