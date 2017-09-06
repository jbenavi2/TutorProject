slider.addChangeListener(new ChangeListener() {
			public void stateChanged (ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
				if (!slider.getValueIsAdjusting() ) {
					int value = slider.getValue();
					System.out.println(value);
					content.removeAll();
					content.add(slider, BorderLayout.SOUTH);
					Assessor panel2 = new Assessor();
					panel2.changeState(value);
					content.add(panel2, BorderLayout.CENTER);
					content.revalidate();
					content.repaint();

				}
			}
		});
