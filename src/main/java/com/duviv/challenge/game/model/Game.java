package com.duviv.challenge.game.model;

import com.duviv.challenge.player.model.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Game_id_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    private int percentage;
    private long scoreTime;

}
