package com.sultanik.physics;

import com.sultanik.physics.ui.GraphicsContext;

public class GroundFriction implements Force {
    public GroundFriction() { }
    public void applyForce(Simulator simulator) {
        for(Particle particle : simulator.getParticles()) {
            if(particle.getY() == 0.0) {
                /* reduce the horizontal velocity by 1/10 */
                particle.setPreviousX(particle.getPreviousX() + (particle.getX() - particle.getPreviousX()) / 10.0);
            }
        }
    }
    public void paint(Simulator simulator, GraphicsContext graphicsContext) {
        graphicsContext.setColor(java.awt.Color.GREEN);
        for(Particle p : simulator.getParticles())
            if(p.getY() == 0.0 && p.getX() != p.getPreviousX())
                graphicsContext.drawLine(p.getX(), p.getY(), p.getPreviousX(), p.getPreviousY());
    }
}