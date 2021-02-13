import React from 'react';
import './ButtonMenu.css'
import { MenuButton } from './MenuButton/MenuButton'


interface ButtonMenuProps {
}

export class ButtonMenu extends React.Component<ButtonMenuProps> {

    render(): JSX.Element {
        return (
            <div className="buttonMenu">
                <MenuButton text="Disponibles" />
                <MenuButton text="Restantes" />
                <MenuButton text="Creditos" />
                <MenuButton text="Aprobadas" />
            </div>
        );
    }
}