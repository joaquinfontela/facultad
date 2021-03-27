#include <SDL2/SDL.h>
#include <SDL2/SDL_video.h>
#include <SDL2/SDL_render.h>

#define WINDOW_WID 1200
#define WINDOW_HEI 900


int main(int argc, char* argv[]) {

	SDL_Init(SDL_INIT_VIDEO);
	SDL_Window* w;
	SDL_Renderer* r;
	SDL_CreateWindowAndRenderer(WINDOW_WID, WINDOW_HEI, 0, &w, &r);
	SDL_Event e;

	bool running = true;
	
	while (running) {
		while (SDL_PollEvent(&e)) {
			if (e.type == SDL_QUIT) running = false;
		}
		int wid, hei;
		SDL_GetWindowSize(w, &wid, &hei);
		SDL_SetRenderDrawColor(r, 0, 255, 255, 0);
		int i;
		for (i = 0; i < wid / 2; i++) {
			SDL_RenderDrawLine(r, wid / 4 + i, hei / 4, wid / 4 + i, 3 * hei / 4);
		}
		SDL_RenderPresent(r);
	}
	
	SDL_DestroyRenderer(r);
	SDL_DestroyWindow(w);
	SDL_Quit();
	
	return 0;
}
