package model;

public interface Command {
    public void doAction(PlayBoard playBoard, Card attacker,Card attacked);
}

class AddAttack implements Command {
    @Override
    public void doAction(PlayBoard playBoard, Card card,Card attacked) {
        for (MonsterCard monsterCard : playBoard.getMonsters())
            monsterCard.addAttack(400);

    }
}
class CantBeAttacked implements Command{

    @Override
    public void doAction(PlayBoard playBoard, Card card,Card attacked) {
        if(playBoard.getMonsters().size()>=2)
            (MonsterCard)card.setAttack(0);
    }

}
class DestroyAttacker implements Command{

    @Override
    public void doAction(PlayBoard playBoard, Card card,Card attacked ) {
        if((MonsterCard)card.getAttack>=(MonsterCard)attacked.getAttack)

    }
}