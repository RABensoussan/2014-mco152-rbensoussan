package bensoussan.opportunity;

public class NasaAPI {

	private mi_images[] mi_images;
	private pcam_images[] pcam_images;
	private ncam_images[] ncam_images;
	private fcam_images[] fcam_images;
	private rcam_images[] rcam_images;
	private course_plot_images[] course_plot_images;

	public images[] getImages() {
		int counter = 0;
		images[] images = new images[300];

		for (mi_images a : mi_images) {
			images[] temp = a.getImages();
			for (images b : temp) {
				images[counter++] = b;
			}
		}
		for (pcam_images a : pcam_images) {
			images[] temp = a.getImages();
			for (images b : temp) {
				images[counter++] = b;
			}
		}
		for (ncam_images a : ncam_images) {
			images[] temp = a.getImages();
			for (images b : temp) {
				images[counter++] = b;
			}
		}
		for (fcam_images a : fcam_images) {
			images[] temp = a.getImages();
			for (images b : temp) {
				images[counter++] = b;
			}
		}
		for (rcam_images a : rcam_images) {
			images[] temp = a.getImages();
			for (images b : temp) {
				images[counter++] = b;
			}
		}
		for (course_plot_images a : course_plot_images) {
			images[] temp = a.getImages();
			for (images b : temp) {
				images[counter++] = b;
			}
		}
		return images;
	}
}
